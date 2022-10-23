package com.loiane.data;

import com.loiane.model.Blog;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisDemo {

    private static SqlSessionFactory factory = null;

    public static void main(String[] args) throws IOException {

        String resource = "SqlMapConfig.xml";
        Reader reader = null;
        SqlSession session = null;

        reader = Resources.getResourceAsReader(resource);

        factory = new SqlSessionFactoryBuilder().build(reader);
        //factory.getConfiguration().addMapper(MyMapper.class);
//        factory.getConfiguration().addMapper(BlogMapper.class);

        reader.close();

        try {
            session = factory.openSession();
//            String version = session.selectOne("getMySQLVersion");
//            System.out.println(version);

            List<Blog> list;
            list = session.selectList("Blog.selectBlog");

            for (Blog blog : list) {
                System.out.println(blog.toString());
            }

            list = session.selectList("BlogBestPractice.selectBlogBestPractice");

            for (Blog blog : list) {
                System.out.println(blog.toString());
            }

        } finally {

            if (session != null) {
                session.close();
            }
        }
    }
}
