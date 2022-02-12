package com.tgt.rysetii.learningresourcesapi.service;

import com.tgt.rysetii.learningresourcesapi.entity.LearningResource;
import com.tgt.rysetii.learningresourcesapi.entity.LearningResourceStatus;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LearningResourceService {

    private List<LearningResource> loadLearningResourceFromCsv(File csvFile){
        List<LearningResource> learningResources = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(csvFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;
            line = bufferedReader.readLine();
            while(line!= null){
                String[] attributes = line.split(",");
                LearningResource learningResource = createLearningResource(attributes);
                learningResources.add(learningResource);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return learningResources;
    }

    private LearningResource createLearningResource(String[] attributes){
        Integer learningResourceId = Integer.parseInt(attributes[0].replaceAll("\\D+", ""));
        String learningResourceName = attributes[1];
        Double costPrice = Double.parseDouble(attributes[2]);
        Double sellingPrice = Double.parseDouble(attributes[3]);
        LearningResourceStatus learningResourceStatus = LearningResourceStatus.valueOf(attributes[4]);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate createdDate = LocalDate.parse(attributes[5], dateFormatter);
        LocalDate publishedDate = LocalDate.parse(attributes[6], dateFormatter);
        LocalDate retiredDate = LocalDate.parse(attributes[7], dateFormatter);

        LearningResource learningResource = new LearningResource();
        learningResource.setLearningResourceId(learningResourceId);
        learningResource.setLearningResourceNameName(learningResourceName);
        learningResource.setCostPrice(costPrice);
        learningResource.setSellingPrice(sellingPrice);
        learningResource.setLearningResourceStatus(learningResourceStatus);
        learningResource.setCreatedDate(createdDate);
        learningResource.setPublishedDate(publishedDate);
        learningResource.setRetiredDate(retiredDate);
        System.out.println(learningResource);
        return learningResource;
    }

}
