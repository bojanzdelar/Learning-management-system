package ca.utoronto.lms.exam.service;

import ca.utoronto.lms.exam.dto.ExamPeriodDTO;
import ca.utoronto.lms.exam.client.FacultyFeignClient;
import ca.utoronto.lms.exam.mapper.ExamPeriodMapper;
import ca.utoronto.lms.exam.model.ExamPeriod;
import ca.utoronto.lms.exam.repository.ExamPeriodRepository;
import ca.utoronto.lms.shared.service.ExtendedService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamPeriodService extends ExtendedService<ExamPeriod, ExamPeriodDTO, Long> {
    private final ExamPeriodRepository repository;
    private final ExamPeriodMapper mapper;
    private final FacultyFeignClient facultyFeignClient;

    public ExamPeriodService(
            ExamPeriodRepository repository,
            ExamPeriodMapper mapper,
            FacultyFeignClient facultyFeignClient) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
        this.facultyFeignClient = facultyFeignClient;
    }

    @Override
    protected List<ExamPeriodDTO> mapMissingValues(List<ExamPeriodDTO> examPeriods) {
        map(
                examPeriods,
                ExamPeriodDTO::getFaculty,
                ExamPeriodDTO::setFaculty,
                facultyFeignClient::getFaculty);

        return examPeriods;
    }
}
