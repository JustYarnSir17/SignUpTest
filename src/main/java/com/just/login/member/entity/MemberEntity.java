package com.just.login.member.entity;

import com.just.login.member.dto.MemberDTO;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "member")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique= true)
    private String memberEmail;

    @Column
    private String memberPassword;

    @Column
    private String MemberName;

//    @Column
//    @Nullable
//    private Double weight;
//
//    @Column
//    @Nullable
//    private Double height;
//
//    @Column
//    @Nullable
//    private Double BMI;

    public static MemberEntity toMemberEntity(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setId(memberDTO.getId());
        memberEntity.setMemberEmail(memberDTO.getMemberEmail());
        memberEntity.setMemberName(memberDTO.getMemberName());
        memberEntity.setMemberPassword(memberDTO.getMemberPassword());
//        memberEntity.setWeight(memberDTO.getWeight());
//        memberEntity.setHeight(memberDTO.getHeight());
//        memberEntity.setBMI(memberDTO.getBmi());
        return  memberEntity;
    }
}
