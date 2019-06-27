package site.wetsion.mybatislearning.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author weixin
 * @version 1.0
 * @CLassName RegistryConfig
 * @date 2019/6/27 11:44 AM
 */
//@Configuration
@Import(TestRegistry.class)
public class RegistryConfig {
}
