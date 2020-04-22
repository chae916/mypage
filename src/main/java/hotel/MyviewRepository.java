package hotel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MyviewRepository extends CrudRepository<Myview, Long> {
    List<Myview> findByregId(Long regId);
    List<Myview> findByid(Long id);
    List<Myview> findByname(String name);
    List<Myview> findBystatus(String status);
//    List<Myview> findByphone(String phone);
//    List<Myview> findBydate(String date);
}