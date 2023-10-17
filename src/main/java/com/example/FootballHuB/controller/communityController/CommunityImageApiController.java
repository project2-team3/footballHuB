package com.example.FootballHuB.controller.communityController;

import com.example.FootballHuB.dto.communityDto.imageDto.CommunityImageCreateRequest;
import com.example.FootballHuB.service.communityService.CommunityImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/image")
public class CommunityImageApiController {

    @Autowired
    private CommunityImageService communityImageService;

    @PostMapping("/img-write")
    public Long createImage(@RequestBody CommunityImageCreateRequest imgCreate){
        return communityImageService.create(imgCreate);
    }

    @GetMapping("/img-read")
    public Long ReadImage(@RequestParam("file") MultipartFile file, @RequestParam("PostNm")Long postNumber) throws IOException {
        return communityImageService.uploadImage(file, postNumber);
    }
}