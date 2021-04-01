package eu.ensup.gestionetablissement.service;

import eu.ensup.gestionetablissement.business.Course;
import eu.ensup.gestionetablissement.business.Person;
import eu.ensup.gestionetablissement.business.Role;
import eu.ensup.gestionetablissement.dao.ExceptionDao;
import eu.ensup.gestionetablissement.dao.ICourseDao;
import eu.ensup.gestionetablissement.dao.IPersonDao;
import eu.ensup.gestionetablissement.dto.CourseDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestCourseServiceWithMockito {
    @Mock
    ICourseDao mockDao;

    @InjectMocks
    CourseService courseService;

    @Test
    public void testGetAll() throws ExceptionDao, ExceptionService {
        List<Course> listeCourse = new ArrayList<Course>();
        listeCourse.add(new Course("math", 12));
        listeCourse.add(new Course("francais", 15));
        listeCourse.add(new Course("histoire", 18));

        when(mockDao.getAll()).thenReturn(listeCourse);
        List<CourseDTO> c = courseService.getAll();
        assertEquals(c.size(), listeCourse.size());
        Mockito.verify(mockDao).getAll();
    }

    @Test
    public void testGetIndex() throws ExceptionDao, ExceptionService {
        when(mockDao.getIndex(anyString(), anyInt())).thenReturn(10);
        int index = courseService.getIndex("math", 10);
        assertEquals(index, 10);
        Mockito.verify(mockDao).getIndex(anyString(), anyInt());
    }

}
