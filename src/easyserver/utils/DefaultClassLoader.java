/**
 * 
 */
package easyserver.utils;

/**
 * 用于加载类的加载类
 * @author cango
 *
 */
public class DefaultClassLoader extends ClassLoader{

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }
    

}
