package com.test.post.construct;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import java.util.*;

@Configuration
@ConfigurationProperties("global")
public class GlobalConfiguratioin {

    @NotEmpty
    private String filePath;

    @Max(2)
    @Min(1)
    private int portCount;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GlobalConfiguratioin{");
        sb.append("filePath='").append(filePath).append('\'');
        sb.append(", portCount=").append(portCount);
        sb.append(", port=").append(port);
        sb.append('}');
        return sb.toString();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public int getPortCount() {
        return portCount;
    }

    public void setPortCount(int portCount) {
        this.portCount = portCount;
    }

    public List<Integer> getPort() {
        return port;
    }

    public void setPort(List<Integer> port) {
        this.port = port;
    }

    private List<Integer> port;



}
