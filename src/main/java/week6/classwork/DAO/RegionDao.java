package week6.classwork.DAO;


import java.util.List;

/**
 * Created with IntelliJ IDEA
 * User: al1
 * Date: 5/12/13
 */
public interface RegionDao {
    void create(Region region);

    Region read(Long id);

    void update(Region region);

    void delete(Region region);

    List<Region> findAll();

    List<Region> findByName(String name);
}
