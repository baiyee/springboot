package com.zx.springboot.utils.util.bean;////
//// Source code recreated from a .class file by IntelliJ IDEA
//// (powered by Fernflower decompiler)
////
//
//package com.st.live.base.util.bean;
//
//import org.junit.Test;
//import org.springframework.asm.ClassVisitor;
//import org.springframework.asm.Type;
//import org.springframework.cglib.core.*;
//import org.springframework.cglib.proxy.InterfaceMaker;
//
//import java.beans.*;
//import java.lang.reflect.Modifier;
//import java.security.ProtectionDomain;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import static org.junit.Assert.assertEquals;
//
//public abstract class BeanCopy {
//    private static final BeanCopy.BeanCopierKey KEY_FACTORY = (BeanCopy.BeanCopierKey)KeyFactory.create(BeanCopy.BeanCopierKey.class);
//    private static final Signature COPY;
//
//    public BeanCopy() {
//    }
//
//    public static BeanCopy build(Class source, Class target) {
//        BeanCopy.Generator gen = new BeanCopy.Generator();
//        gen.setSource(source);
//        gen.setTarget(target);
//        return gen.create();
//    }
//
//
//    public abstract void copy(Object var1, Object var2);
//
//    static {
//        COPY = new Signature("copy", Type.VOID_TYPE, new Type[]{Constants.TYPE_OBJECT, Constants.TYPE_OBJECT});
//    }
//
//
//
//    public static class Generator extends AbstractClassGenerator {
//        private static final Source SOURCE = new Source(BeanCopy.class.getName());
//        private Class source;
//        private Class target;
//
//        public Generator() {
//            super(SOURCE);
//        }
//
//        public void setSource(Class source) {
//            if (!Modifier.isPublic(source.getModifiers())) {
//                this.setNamePrefix(source.getName());
//            }
//
//            this.source = source;
//        }
//
//        public void setTarget(Class target) {
//            if (!Modifier.isPublic(target.getModifiers())) {
//                this.setNamePrefix(target.getName());
//            }
//
//            this.target = target;
//        }
//
//        protected ClassLoader getDefaultClassLoader() {
//            return this.source.getClassLoader();
//        }
//
//        protected ProtectionDomain getProtectionDomain() {
//            return ReflectUtils.getProtectionDomain(this.source);
//        }
//
//        public BeanCopy create() {
//            Object key = BeanCopy.KEY_FACTORY.newInstance(this.source.getName(), this.target.getName());
//            Object bean = super.create(key);
//            return (BeanCopy)bean;
//        }
//
////        public void generateClass2(ClassVisitor v) throws Exception {
////            PropertyDescriptor[] getters = ReflectUtils.getBeanGetters(this.source);
////            PropertyDescriptor[] setters = ReflectUtils.getBeanProperties(this.target);
////
////            int size = this.props.size();
////            String[] names = (String[])((String[])this.props.keySet().toArray(new String[size]));
////            Type[] types = new Type[size];
////
////            for(int i = 0; i < size; ++i) {
////                types[i] = (Type)this.props.get(names[i]);
////            }
////
////            ClassEmitter ce = new ClassEmitter(v);
////            ce.begin_class(46, 1, this.getClassName(), this.source != null ? Type.getType(this.source) : Constants.TYPE_OBJECT, (Type[])null, (String)null);
////            EmitUtils.null_constructor(ce);
////            EmitUtils.add_properties(ce, names, types);
////            ce.end_class();
////        }
//
//        public void generateClass(ClassVisitor v) {
//
//            Type targetType = Type.getType(this.target);
//            Type sourceType = Type.getType(this.source);
//            Signature signature = new Signature("copy", Type.VOID_TYPE, new Type[]{Constants.TYPE_OBJECT, Constants.TYPE_OBJECT});
//            InterfaceMaker interfaceMaker = new InterfaceMaker();
//            interfaceMaker.add(signature, new Type[0]);
//
//            ClassEmitter ce = new ClassEmitter(v);
////            ce.begin_class(46, 1, this.getClassName(), this.source != null ? Type.getType(this.source) : Constants.TYPE_OBJECT, (Type[])null, (String)null);
//
//            ce.begin_class(46, 1, this.getClassName(), Type.getType(BeanCopy.class), (Type[])null, (String)null);
//            EmitUtils.null_constructor(ce);
//            CodeEmitter e = ce.begin_method(1, COPY,  (Type[])null);
//            List<MethodDescriptor> getters = getBeanGetters(this.source);
//            List<MethodDescriptor> setters =  getBeanSetters(this.target);
//            Map names = new HashMap();
//            for(MethodDescriptor method : getters) {
//                names.put(method.getMethod().getName().substring(3), method);
//            }
//            for(MethodDescriptor setter: setters) {
//                MethodDescriptor getter = (MethodDescriptor)names.get(setter.getMethod().getName().substring(3));
//                if (getter != null) {
//                    MethodInfo read = ReflectUtils.getMethodInfo(getter.getMethod());
//                    MethodInfo write = ReflectUtils.getMethodInfo(setter.getMethod());
//                    {
//                        e.dup2();
//                        e.invoke(read);
//                        e.invoke(write);
//                    }
//                }
//            }
//            e.return_value();
//            e.end_method();
//            ce.end_class();
//        }
//
//
//        protected Object firstInstance(Class type) {
//            return ReflectUtils.newInstance(type);
//        }
//
//        protected Object nextInstance(Object instance) {
//            return instance;
//        }
//    }
//
//    interface BeanCopierKey {
//        Object newInstance(String source, String target);
//    }
//
//    private static List<MethodDescriptor> getBeanSetters(Class type){
//        return getMethodDescriptor(type,false,true);
//    }
//    private static List<MethodDescriptor> getBeanGetters(Class type){
//        return getMethodDescriptor(type,true,false);
//    }
//
//    private static List<MethodDescriptor> getMethodDescriptor(Class type,boolean read,boolean write ) {
//        try {
//            BeanInfo info = Introspector.getBeanInfo(type, Object.class);
//            MethodDescriptor[] methods = info.getMethodDescriptors();
//            List methodList = new ArrayList(methost.length);
//            for (int i = 0; i < methost.length; i++) {
//                MethodDescriptor method = methods[i];
//                if ((read && method.getMethod().getName().contains("get")) ||
//                        (write && method.getMethod().getName().contains("set"))) {
//                    methodList.add(method);
//                }
//            }
//            return methodList;
//        }
//        catch (IntrospectionException e) {
//            throw new CodeGenerationException(e);
//        }
//    }
//    public static void main(String[] args) {
//
////        BeanCopierKey keyFactory = (BeanCopierKey) KeyFactory.create(BeanCopierKey.class);
////        Object key = keyFactory.newInstance("foo", "42");
////        Object key1 = keyFactory.newInstance("foo", "42");
////        assertEquals(key,key1);//测试参数相同，结果是否相等
//
//        Test1 test1 = new Test1(10,"testName");
//        Test2 test2 = new Test2();
//        BeanCopy bc =  BeanCopy.build(test1.getClass(),test2.getClass());
//        bc.copy(test1,test2);
//
//        System.out.println(test2.toString());
//
//
//    }
//
//    @Test
//    public void testInterfaceMaker() throws Exception {
//        Signature signature = new Signature("foo", Type.DOUBLE_TYPE, new Type[]{Type.INT_TYPE});
//        InterfaceMaker interfaceMaker = new InterfaceMaker();
//        interfaceMaker.add(signature, new Type[0]);
//        Class iface = interfaceMaker.create();
//        assertEquals(1, iface.getMethods().length);
//        assertEquals("foo", iface.getMethods()[0].getName());
//        assertEquals(double.class, iface.getMethods()[0].getReturnType());
//    }
//}
