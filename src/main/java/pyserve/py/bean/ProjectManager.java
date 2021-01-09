package pyserve.py.bean;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zzx
 * @version 1.0
 * @date 2020/12/29 23:47
 */
@Component
public class ProjectManager {
    private Map<Integer ,Project> projectMap=new ConcurrentHashMap<>();

    public Map<Integer, Project> getProjectMap() {
        return projectMap;
    }


    public void addProject(Project project){
        projectMap.put(project.getProjectid(),project);
    }

    public void removeProject(int projectid){
        projectMap.remove(projectid);
    }


}
