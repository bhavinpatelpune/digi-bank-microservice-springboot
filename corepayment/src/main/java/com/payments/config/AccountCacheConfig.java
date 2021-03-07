package com.payments.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizePolicy;

@Configuration
public class AccountCacheConfig {
	
	@Bean
	public Config cacheConfig() {
		return new Config().setInstanceName("hazel-instance")
						   .addMapConfig(new MapConfig()
								   			.setName("account-cache")
								   			.setTimeToLiveSeconds(3000)
								   			//.setMapStoreConfig(new Map)
								   );
	}

}
