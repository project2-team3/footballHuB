package com.example.FootballHuB.dto.communityDto.imageDto;

import com.example.FootballHuB.entity.communityEntity.CommunityPost;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@ToString
public class CommunityImageCreateRequest {
    private Long id;
    private Long postNumber;
    private Long memberNumber;
    private String imageName;
    private String imageSrc;

    public CommunityImageCreateRequest() {
    }

    public CommunityImageCreateRequest(Long id, Long postNumber, Long memberNumber, String imageName, String imageSrc) {
        this.id = id;
        this.postNumber = postNumber;
        this.memberNumber = memberNumber;
        this.imageName = imageName;
        this.imageSrc = imageSrc;
    }

    private static ModelMapper modelMapper = new ModelMapper();

    public static CommunityImageCreateRequest of (CommunityImageCreateRequest communityImageCreateRequest){
        return modelMapper.map(communityImageCreateRequest,CommunityImageCreateRequest.class);
    }
}
