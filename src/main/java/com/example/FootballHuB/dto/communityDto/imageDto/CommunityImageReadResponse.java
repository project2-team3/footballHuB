package com.example.FootballHuB.dto.communityDto.imageDto;


import com.example.FootballHuB.entity.communityEntity.CommunityPost;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommunityImageReadResponse {
    private Long id;
    private Long postNumber;
    private Long memberNumber;
    private String imageName;
    private String imageSrc;

    public CommunityImageReadResponse() {
    }

    public CommunityImageReadResponse(Long id, Long postNumber, Long memberNumber, String imageName, String imageSrc) {
        this.id = id;
        this.postNumber = postNumber;
        this.memberNumber = memberNumber;
        this.imageName = imageName;
        this.imageSrc = imageSrc;
    }
}
