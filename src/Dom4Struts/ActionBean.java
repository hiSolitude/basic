package Dom4Struts;

import java.util.Map;

/**
 * Created by solitude on 2017/2/13.
 */
public class ActionBean {
    private String name;
    private String classPath;
    private String methodName;
    private Map<String,Result> results;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassPath() {
        return classPath;
    }

    public void setClassPath(String classPath) {
        this.classPath = classPath;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Map<String, Result> getResults() {
        return results;
    }

    public void setResults(Map<String, Result> results) {
        this.results = results;
    }
}
