package ca.utoronto.lms.faculty.repository;

import ca.utoronto.lms.faculty.model.StudyProgram;
import ca.utoronto.lms.shared.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyProgramRepository extends BaseRepository<StudyProgram, Long> {
    @Override
    @Query(
            "select x from #{#entityName} x where cast(x.id as string) like :search "
                    + "or x.name like :search or x.description like :search")
    Page<StudyProgram> findContaining(Pageable pageable, String search);
}
