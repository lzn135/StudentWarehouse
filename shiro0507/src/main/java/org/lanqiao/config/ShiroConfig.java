package org.lanqiao.config;

import org.springframework.context.annotation.Bean;

import java.util.LinkedHashMap;
import java.util.Map;

public class ShiroConfig {
	public shiroFilterFactoryBean shiroFilterFactoryBean


	Map<String, String> map = new LinkedHashMap<>();
			map.put("/update","anon");
			map.put("/delete","authc");
			shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
			return shiroFilteFactoryBean;
		}
}
