package ca.utoronto.lms.exam.service;

import ca.utoronto.lms.exam.dto.ExamRealizationDTO;
import ca.utoronto.lms.exam.dto.ExamTermDTO;
import ca.utoronto.lms.exam.dto.SubjectDTO;
import ca.utoronto.lms.exam.feign.SubjectFeignClient;
import ca.utoronto.lms.exam.mapper.ExamRealizationMapper;
import ca.utoronto.lms.exam.model.ExamRealization;
import ca.utoronto.lms.exam.repository.ExamRealizationRepository;
import ca.utoronto.lms.shared.security.SecurityUtils;
import ca.utoronto.lms.shared.service.ExtendedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ExamRealizationService
        extends ExtendedService<ExamRealization, ExamRealizationDTO, Long> {
    private final ExamRealizationRepository repository;
    private final ExamRealizationMapper mapper;

    @Autowired private ExamTermService examTermService;

    @Autowired private SubjectFeignClient subjectFeignClient;

    public ExamRealizationService(
            ExamRealizationRepository repository, ExamRealizationMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected List<ExamRealizationDTO> mapMissingValues(List<ExamRealizationDTO> examRealizations) {
        map(
                examRealizations,
                ExamRealizationDTO::getSubjectEnrollment,
                ExamRealizationDTO::setSubjectEnrollment,
                (ID) -> subjectFeignClient.getSubjectEnrollment(ID));

        return examRealizations;
    }

    public Page<ExamRealizationDTO> findByExamTermId(Long id, Pageable pageable, String search) {
        if (!SecurityUtils.hasAuthority(SecurityUtils.ROLE_ADMIN)) {
            ExamTermDTO examTerm = examTermService.findById(Set.of(id)).get(0);
            SubjectDTO subject = examTerm.getExam().getSubject();

            Long teacherId = SecurityUtils.getTeacherId();
            if (!teacherId.equals(subject.getProfessor().getId())
                    && !teacherId.equals(subject.getAssistant().getId())) {
                // TODO: FORBIDDEN
                throw new RuntimeException(
                        "You are not authorized to view these exam realizations.");
            }
        }

        Page<ExamRealizationDTO> examRealizations =
                repository
                        .findByExamTermIdContaining(id, pageable, "%" + search + "%")
                        .map(mapper::toDTO);
        return examRealizations.getContent().isEmpty()
                ? examRealizations
                : new PageImpl<>(
                        this.mapMissingValues(examRealizations.getContent()),
                        pageable,
                        examRealizations.getTotalElements());
    }
}
