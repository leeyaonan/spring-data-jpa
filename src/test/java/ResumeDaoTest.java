import com.leeyaonan.dao.ResumeDao;
import com.leeyaonan.pojo.Resume;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

/**
 * @Author leeyaonan
 * @Date 2020/5/5 11:25
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ResumeDaoTest {

    // 要测试IOC哪个对象注入即可
    @Autowired
    private ResumeDao resumeDao;

    /**
     * Dao层接口调用，分成两块：
     * 1. 基础的增删改查
     * 2. 专门针对查询的详细分析使用
     */


    @Test
    public void testFindById() {
        /*
         * 执行sql：
         * Hibernate:
         * select resume0_.id as id1_0_0_, resume0_.address as address2_0_0_, resume0_.name as name3_0_0_,
         * resume0_.phone as phone4_0_0_ from resume resume0_ where resume0_.id=?
         * */
        Optional<Resume> optional = resumeDao.findById(1L);
        Resume resume = optional.get();
        System.out.println(resume);

    }

    @Test
    public void testFindOne() {
        Resume resume = new Resume();
        resume.setId(1L);
        resume.setName("蓝宝宝");
        Example<Resume> example = Example.of(resume);
        /*
         * Hibernate:
         * select resume0_.id as id1_0_, resume0_.address as address2_0_, resume0_.name as name3_0_, resume0_.phone as phone4_0_
         * from resume resume0_ where resume0_.id=1
         * */
        Optional<Resume> one = resumeDao.findOne(example);
        Resume resume1 = one.get();
        System.out.println(resume1);
    }

    @Test
    public void testSave() {
        // 新增和更新都使用save方法，通过传入的对象的主键的有无来区分，没有主键就新增，有主键则更新

        Resume resume = new Resume();
        resume.setId(4L);
        resume.setName("蓝朵朵");
        resume.setAddress("天津");
        resume.setPhone("19999999999");
        /*
        * Hibernate: select resume0_.id as id1_0_0_, resume0_.address as address2_0_0_, resume0_.name as name3_0_0_, resume0_.phone as phone4_0_0_ from resume resume0_ where resume0_.id=?
          Hibernate: insert into resume (address, name, phone) values (?, ?, ?)
        * */
        Resume save = resumeDao.save(resume);
        System.out.println(save);
    }

    @Test
    public void testDelete() {
        resumeDao.deleteById(5L);
    }

    @Test
    public void testFindAll() {
        List<Resume> all = resumeDao.findAll();
        System.out.println(all);
    }
}
