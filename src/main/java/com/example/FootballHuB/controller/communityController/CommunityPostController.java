package com.example.FootballHuB.controller.communityController;

import com.example.FootballHuB.dto.OrderDto;
import com.example.FootballHuB.dto.communityDto.postDto.CommunityPostCreateRequest;
import com.example.FootballHuB.dto.communityDto.postDto.CommunityPostReadResponse;
import com.example.FootballHuB.service.communityService.CommunityPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RequestMapping("/gall")
@Controller
@RequiredArgsConstructor
public class CommunityPostController {

    private final CommunityPostService communityPostService;

    @GetMapping("/write")
    public String createPost(Model model){

        return "community/write";
    }

    @GetMapping("/{id}")
    public String readPost(Model model){
        return "community/readPost";
    }


    @GetMapping
    public String listPosts(Model model, @RequestParam(name = "page", defaultValue = "0") int page, @RequestParam(name = "size", defaultValue = "10") int size) {
        // page와 size 매개변수를 사용하여 페이지 번호와 페이지 크기를 가져옵니다.

        // 이제 page와 size를 사용하여 데이터를 로드하거나 다른 작업을 수행할 수 있습니다.

        return "community/post"; // 페이지 템플릿 이름
    }
}
