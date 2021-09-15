/*
 * Copyright 2002-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.beans.factory.config;

import org.springframework.beans.BeansException;

/**
 * BeanFactoryPostProcessor接口
 *
 * 工厂钩子，允许自定义修改应用程序上下文的 bean 定义，调整上下文底层 bean 工厂的 bean 属性值。
 * Factory hook that allows for custom modification of an application context's
 * bean definitions, adapting the bean property values of the context's underlying
 * bean factory.
 *
 * <p>对于面向系统管理员的自定义配置文件很有用，这些文件覆盖了在应用程序上下文中配置的 bean 属性。
 * 请参阅 {@link PropertyResourceConfigurer} 及其具体实现，以了解满足此类配置需求的开箱即用解决方案。
 * <p>Useful for custom config files targeted at system administrators that
 * override bean properties configured in the application context. See
 * {@link PropertyResourceConfigurer} and its concrete implementations for
 * out-of-the-box solutions that address such configuration needs.
 *
 * <p>{@code BeanFactoryPostProcessor} 可以与 bean 定义交互和修改，但绝不能与 bean 实例交互。
 * 这样做可能会导致 bean 过早实例化、违反容器并导致意外的副作用。
 * 如果需要 bean 实例交互，请考虑实现 {@link BeanPostProcessor}。
 * <p>A {@code BeanFactoryPostProcessor} may interact with and modify bean
 * definitions, but never bean instances. Doing so may cause premature bean
 * instantiation, violating the container and causing unintended side-effects.
 * If bean instance interaction is required, consider implementing
 * {@link BeanPostProcessor} instead.
 *
 *
 * <h3>Registration<h3>
 * <p>{@code ApplicationContext} 在其 bean 定义中自动检测
 * {@code BeanFactoryPostProcessor} bean，并在创建任何其他 bean 之前应用它们。
 * {@code BeanFactoryPostProcessor} 也可以通过 {@code ConfigurableApplicationContext} 以编程方式注册。
 * <h3>Registration</h3>
 * <p>An {@code ApplicationContext} auto-detects {@code BeanFactoryPostProcessor}
 * beans in its bean definitions and applies them before any other beans get created.
 * A {@code BeanFactoryPostProcessor} may also be registered programmatically
 * with a {@code ConfigurableApplicationContext}.
 *
 *
 * <h3>Ordering<h3>
 * <p>{@code BeanFactoryPostProcessor} 在
 * {@code ApplicationContext} 中自动检测到的 bean 将根据
 * {@link org.springframework.core.PriorityOrdered} 和
 * {@link org.springframework.core.Ordered} 语义。相比之下，以编程方式注册到
 * {@code ConfigurableApplicationContext} 的
 * {@code BeanFactoryPostProcessor} bean 将
 * 按注册顺序应用；对于以编程方式注册的后处理器，通过实现
 * {@code PriorityOrdered} 或 {@code Ordered} 接
 * 口表达的任何排序语义都将被忽略。此外，{@code BeanFactoryPostProcessor} bean 不考虑
 * {@link org.springframework.core.annotation.Order @Order} 注释。
 * <h3>Ordering</h3>
 * <p>{@code BeanFactoryPostProcessor} beans that are autodetected in an
 * {@code ApplicationContext} will be ordered according to
 * {@link org.springframework.core.PriorityOrdered} and
 * {@link org.springframework.core.Ordered} semantics. In contrast,
 * {@code BeanFactoryPostProcessor} beans that are registered programmatically
 * with a {@code ConfigurableApplicationContext} will be applied in the order of
 * registration; any ordering semantics expressed through implementing the
 * {@code PriorityOrdered} or {@code Ordered} interface will be ignored for
 * programmatically registered post-processors. Furthermore, the
 * {@link org.springframework.core.annotation.Order @Order} annotation is not
 * taken into account for {@code BeanFactoryPostProcessor} beans.
 *
 * @author Juergen Hoeller
 * @author Sam Brannen
 * @since 06.07.2003
 * @see BeanPostProcessor
 * @see PropertyResourceConfigurer
 */
@FunctionalInterface
public interface BeanFactoryPostProcessor {

	/**
	 * 在标准初始化之后修改应用程序上下文的内部 bean 工厂。所有 bean 定义都将被加载，
	 * 但尚未实例化任何 bean。这甚至允许覆盖或添加属性，即使是急切初始化的 bean。
	 *
	 * Modify the application context's internal bean factory after its standard
	 * initialization. All bean definitions will have been loaded, but no beans
	 * will have been instantiated yet. This allows for overriding or adding
	 * properties even to eager-initializing beans.
	 *
	 * @param beanFactory the bean factory used by the application context
	 * @throws org.springframework.beans.BeansException in case of errors
	 */
	void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;

}
