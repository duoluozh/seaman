package rapid;

import cn.org.rapid_framework.generator.GeneratorFacade;

import java.io.File;

public class RapidGenerateFiles {
    public static void main(String[] args) throws Exception {

        /**
         * 用法:例子如下
         *
         * 0.首先修改resources/generator.xml,修改为当前正确的信息(表注释,模块名(如:goods),作者姓名,表前缀,数据库用户名/密码)
         * 1.修改以下代码中的表名(如:goods_cate)
         * 2.右击 Run,成功后,查看output目录
         * 3.将service-goods-api,service-goods-app,service-goods-bean,service-goods-core4个目录直接拷贝到sbc-service-goods模块
         * 4.根据情况,删除多生成的代码
         *
         * ---------------------------------------WARNING--------------------------------------------------
         * 0. 切记, 不支持循环, 因为xml文件中你还要修改注释
         * 1. 不支持联合主键, 可能出现神奇的现象
         * 2. 因为数据库映射Bean已经继承了一个公共Bean, 存在了公共的createPerson, createTime, updatePerson, updateTime.
         *    所以生成之后需要到core的model.root下面去掉.
         * 3. 欲知更多, 请查看 README.MD
         *
         */
        GeneratorFacade g = new GeneratorFacade();
        g.getGenerator().addTemplateRootDir(System.getProperty("user.dir").concat(File.separator).concat("template"));
        // 需要生成代码的表名
        g.generateByTable("ysltest");
    }
}
