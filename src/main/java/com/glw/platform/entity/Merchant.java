package com.glw.platform.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * 表名：merchant
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "merchant")
public class Merchant {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 商户名称
     */
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    /**
     * 商户 logo
     */
    @Column(name = "logo_url", nullable = false)
    private String logoUrl;

    /**
     * 商户营业执照
     */
    @Column(name = "business_license_url", nullable = false)
    private String businessLicenseUrl;

    /**
     * 商户联系电话
     */
    @Column(name = "phone", nullable = false)
    private String phone;

    /**
     * 商户地址
     */
    @Column(name = "address", nullable = false)
    private String address;

    /**
     * 是否通过审核
     */
    @Column(name = "is_audit", nullable = false)
    private Boolean isAudit;
}