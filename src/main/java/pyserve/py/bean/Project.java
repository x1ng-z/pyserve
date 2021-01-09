package pyserve.py.bean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zzx
 * @version 1.0
 * @date 2020/12/29 23:22
 */
public class Project {
    private Map<Integer,Module> moduleMap=new ConcurrentHashMap<>();

    private int projectid;
    public void addModule(Module module){
        moduleMap.put(module.getNodeid(),module);
    }

    public void removeModule(int nodeid){
        moduleMap.remove(nodeid);
    }

    public Map<Integer, Module> getModuleMap() {
        return moduleMap;
    }

    public int getProjectid() {
        return projectid;
    }

    public void setProjectid(int projectid) {
        this.projectid = projectid;
    }
}
