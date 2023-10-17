package com.example.FootballHuB.service.communityService;

import com.example.FootballHuB.dto.communityDto.imageDto.CommunityImageCreateRequest;
import com.example.FootballHuB.entity.communityEntity.CommunityImage;
import com.example.FootballHuB.repository.communityRepository.CommunityImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class CommunityImageService {
    @Autowired
    private CommunityImageRepository communityImageRepository;


    public Long create(final CommunityImageCreateRequest c) {
        CommunityImage img = new CommunityImage(
                c.getPostNumber(),
                c.getMemberNumber(),
                c.getImageName(),
                c.getImageSrc()
        );
        return communityImageRepository.save(img).getId();
    }

    public Long uploadImage(MultipartFile file, Long postNumber) throws IOException {
        try {
            String imageName = file.getOriginalFilename();
            byte[] imageBytes = file.getBytes();

            // 이미지 엔티티 생성 및 저장
            CommunityImage image = new CommunityImage();
            image.setPostNumber(postNumber);
            image.setImageName(imageName);
            // 저장된 이미지 경로나 바이트를 따로 저장할 수 있습니다
            // image.setImgSrc("경로 또는 Base64 인코딩 된 이미지 바이트 배열");
            image = communityImageRepository.save(image);

            return image.getId();
        } catch (
                IOException e) {
            // 예외 처리
            e.printStackTrace();
            return -1L; // 실패 시 -1 반환 또는 다른 예외 처리 방식 사용
        }
    }

    public List<CommunityImage> getImagesForPost(Long postNumber) {
        return communityImageRepository.findByPostNumber(postNumber);
    }

}
