package ca.utoronto.lms.exam.service;

import ca.utoronto.lms.exam.dto.ExamRealizationDTO;
import ca.utoronto.lms.exam.feign.SubjectFeignClient;
import ca.utoronto.lms.exam.mapper.ExamRealizationMapper;
import ca.utoronto.lms.exam.model.ExamRealization;
import ca.utoronto.lms.exam.repository.ExamRealizationRepository;
import ca.utoronto.lms.shared.service.ExtendedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamRealizationService
        extends ExtendedService<ExamRealization, ExamRealizationDTO, Long> {
    private final ExamRealizationRepository repository;
    private final ExamRealizationMapper mapper;

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
                (examRealization) -> examRealization.getSubjectEnrollment(),
                (examRealization, subjectEnrollment) ->
                        examRealization.setSubjectEnrollment(subjectEnrollment),
                (ID) -> subjectFeignClient.getSubjectEnrollment(ID));

        return examRealizations;
    }
}
