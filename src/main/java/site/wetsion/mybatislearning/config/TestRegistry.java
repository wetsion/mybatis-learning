package site.wetsion.mybatislearning.config;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author weixin
 * @version 1.0
 * @CLassName TestRegistry
 * @date 2019/6/27 11:45 AM
 */
@Slf4j
public class TestRegistry implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        log.info("test");
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        FileSystemResource resource = new FileSystemResource("/Users/weixin/dev/IdeaProjects/mybatis-learning/target/classes/site/wetsion/mybatislearning/mapper/TestMapper.class");
        beanDefinition.setResource(resource);
        beanDefinition.setSource(resource);
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("site.wetsion.mybatislearning.mapper.TestMapper");
        beanDefinition.setScope("singleton");
        beanDefinition.setBeanClass(MapperFactoryBean.class);
        beanDefinition.setBeanClassName("site.wetsion.mybatislearning.mapper.TestMapper");
//        BeanDefinitionHolder beanDefinitionHolder = new BeanDefinitionHolder();
        registry.registerBeanDefinition("testMapper", beanDefinition);
    }
}
