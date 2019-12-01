package com.glw.platform.dao;

import com.glw.platform.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : glw
 * @date : 2019/11/29
 * @time : 17:07
 * @Description : Merchant DAO接口
 */
public interface MerchantDao extends JpaRepository<Merchant, Integer> {

    /**
     * 根据商户名称获取商户对象
     * @param name
     * @return
     */
    Merchant findByName(String name);
}
