package cn.zeroclian.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author ZeroClian
 * @date 2023-03-21 23:13
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
