package com.example.KTCK_Lan3_THLTDD.Entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Ca")
@Getter
@Setter
@NoArgsConstructor
public class Ca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tenkhoahoc")
    private String tenKhoaHoc;

    @Column(name = "tenthuonggoi")
    private String tenThuongGoi;

    @Column(name = "dactinh")
    private String dacTinh;

    @Column(name = "mausac")
    private String mauSac;

    @Column(name = "image_ca")
    private String imageCa;

}
