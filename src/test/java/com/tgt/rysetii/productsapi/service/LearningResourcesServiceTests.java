package com.tgt.rysetii.productsapi.service;

import com.tgt.rysetii.learningresourcesapi.entity.LearningResource;
import com.tgt.rysetii.learningresourcesapi.entity.LearningResourceStatus;
import com.tgt.rysetii.learningresourcesapi.repository.LearningResourceRepository;
import com.tgt.rysetii.learningresourcesapi.service.LearningResourceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/** @MockitoExtension tells mockito to evaluate those @Mock annotations because JUnit doesn't do this automatically */
@ExtendWith(MockitoExtension.class)
public class LearningResourcesServiceTests {

    /**
     * This will create a dummy LearningResourceRepository object.
     * By default, it will do nothing when a method is called and returns 'null' if the method has a return value
     * */
    @Mock
    LearningResourceRepository learningResourceRepository;

    /** below is another way of creating a mock object. In this case, no need to use @MockitoExtension */
//    LearningResourceRepository learningResourceRepository = Mockito.mock(LearningResourceRepository.class);

    /**
     * Instead of creating the EmployeeService object manually, we can use @InjectMocks annotation on the employeeRepository field
     * Mockito will then try to instantiate fields annotated with @InjectMocks by passing all mocks into a constructor.
     * Note that we need to provide such a constructor for Mockito to work reliably.
     * If Mockito doesn’t find a constructor, it will try setter injection or field injection, but the cleanest way is still a constructor.
     * */
    @InjectMocks
    LearningResourceService learningResourceService;

    @Test
    public void getProfitMarginsOfAllTheAvailableLearningResources(){
        List<LearningResource> learningResources = new ArrayList<>();
        LearningResource learningResource1 = new LearningResource(1311, "Test Name 1", 100.0, 120.0, LearningResourceStatus.LIVE, LocalDate.now(), LocalDate.now().plusMonths(5), LocalDate.now().plusYears(2));
        LearningResource learningResource2 = new LearningResource(1312, "Test Name 2", 120.0, 180.0, LearningResourceStatus.LIVE, LocalDate.now(), LocalDate.now().plusMonths(6), LocalDate.now().plusYears(3));
        learningResources.add(learningResource1);
        learningResources.add(learningResource2);

        List<Double> expectedProfitMargins = learningResources.stream()
                .map(lr -> ((lr.getSellingPrice() - lr.getCostPrice())/lr.getSellingPrice()))
                .collect(toList());

        when(learningResourceRepository.findAll()).thenReturn(learningResources);

        List<Double> actualProfitMargins = learningResourceService.getProfitMargin();
        assertEquals(expectedProfitMargins, actualProfitMargins, "Wrong profit margins");
    }

    @Test
    public void sortTheLearningResourceBasedOnProfitMarginInNonIncreasingOrder(){
        List<LearningResource> learningResources = new ArrayList<>();
        LearningResource learningResource1 = new LearningResource(1311, "Test Name 1", 100.0, 120.0, LearningResourceStatus.LIVE, LocalDate.now(), LocalDate.now().plusMonths(5), LocalDate.now().plusYears(2));
        LearningResource learningResource2 = new LearningResource(1312, "Test Name 2", 120.0, 180.0, LearningResourceStatus.LIVE, LocalDate.now(), LocalDate.now().plusMonths(6), LocalDate.now().plusYears(3));
        learningResources.add(learningResource1);
        learningResources.add(learningResource2);

        learningResources.sort((lr1, lr2) -> {
            Double profitMargin1 = (lr1.getSellingPrice() - lr1.getCostPrice())/lr1.getSellingPrice();
            Double profitMargin2 = (lr2.getSellingPrice() - lr2.getCostPrice())/lr2.getSellingPrice();

            return profitMargin2.compareTo(profitMargin1) ;
        });

        when(learningResourceRepository.findAll()).thenReturn(learningResources);

        List<LearningResource> learningResourcesSorted = learningResourceService.sortLearningResourcesByProfitMargin();

        assertEquals(learningResources, learningResourcesSorted, "The learning resources are not sorted by profit margin");
    }

    @Test
    public void saveTheLearningResources(){
        List<LearningResource> learningResources = new ArrayList<>();
        LearningResource learningResource1 = new LearningResource(1311, "Test Name 1", 100.0, 120.0, LearningResourceStatus.LIVE, LocalDate.now(), LocalDate.now().plusMonths(5), LocalDate.now().plusYears(2));
        LearningResource learningResource2 = new LearningResource(1312, "Test Name 2", 120.0, 180.0, LearningResourceStatus.LIVE, LocalDate.now(), LocalDate.now().plusMonths(6), LocalDate.now().plusYears(3));
        LearningResource learningResource3 = new LearningResource(1313, "Test Name 3", 120.0, 180.0, LearningResourceStatus.LIVE, LocalDate.now(), LocalDate.now().plusMonths(6), LocalDate.now().plusYears(3));
        learningResources.add(learningResource1);
        learningResources.add(learningResource2);
        learningResources.add(learningResource3);

        learningResourceService.saveLearningResources(learningResources);

        verify(learningResourceRepository, times(learningResources.size())).save(any(LearningResource.class));
    }

    @Test
    public void deleteLearningResourceById(){
        int learningResourceId = 1234;

        /**
         *  doNothing() is Mockito's default behavior for void methods. The below is executed by Mockito by default for this method
         *  doNothing().when(repository).deleteById(any(String.class));
         * */

        learningResourceService.deleteLearningResourceById(learningResourceId);

        verify(learningResourceRepository, times(1)).deleteById(learningResourceId);
    }

}

