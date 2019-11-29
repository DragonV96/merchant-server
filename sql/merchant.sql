CREATE TABLE `merchant` (
    `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
    `name` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '商户名称',
    `logo_url` varchar(256) COLLATE utf8_bin NOT NULL COMMENT '商户 logo',
    `business_license_url` varchar(256) COLLATE utf8_bin NOT NULL COMMENT '商户营业执照',
    `phone` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '商户联系电话',
    `address` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '商户地址',
    `is_audit` BOOLEAN NOT NULL COMMENT '是否通过审核',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARACTER=utf8 COMMENT '商户信息表';