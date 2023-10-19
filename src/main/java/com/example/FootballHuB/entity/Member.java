package com.example.FootballHuB.entity;

import com.example.FootballHuB.constant.Role;
import com.example.FootballHuB.dto.MemberFormDto;
import com.example.FootballHuB.entity.gameEntity.Game;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="member")
@Getter @Setter
@ToString
public class Member extends BaseEntity {

    @Id
    @Column(name="member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String address;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String provider;

    private String providerId;

    @OneToMany(mappedBy = "member")
    private List<Game> games;

    private Integer spinCount = 1;

//    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
//    private List<ItemComment> itemComments = new ArrayList<>();


    public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder){
        Member member = new Member();
        member.setName(memberFormDto.getName());
        member.setEmail(memberFormDto.getEmail());
        member.setAddress(memberFormDto.getAddress());
        String password = passwordEncoder.encode(memberFormDto.getPassword());
        member.setPassword(password);
        member.setRole(Role.ADMIN);
        return member;
    }
    public String getRoleValue() {
        return this.role.getValue();
    }

    public Integer getSpinCount() {
        // Spin count가 null인 경우 0을 반환하도록 수정
        return spinCount != null ? spinCount : 0;
    }
}
