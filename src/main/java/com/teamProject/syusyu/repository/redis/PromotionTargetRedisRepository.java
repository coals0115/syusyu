package com.teamProject.syusyu.repository.redis;

import com.teamProject.syusyu.entity.redis.PromotionTargetDataEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionTargetRedisRepository extends CrudRepository<PromotionTargetDataEntity, String> {
} 