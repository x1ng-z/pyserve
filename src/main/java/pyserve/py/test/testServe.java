package pyserve.py.test;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pyserve.py.bean.Module;
import pyserve.py.bean.Project;
import pyserve.py.bean.ProjectManager;
import pyserve.py.pyserve.CommandImp;
import pyserve.py.session.Session;
import pyserve.py.session.SessionManager;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author zzx
 * @version 1.0
 * @date 2020/12/29 23:33
 */
@Component
public class testServe implements Runnable {
    @Autowired
    private SessionManager sessionManager;

    @Autowired
    private ProjectManager projectManager;

    @PostConstruct
    public void init(){
        Project project=new Project();
        Module module=new Module();
        module.setNodeid(1234);
        project.addModule(module);
//        projectManager.getProjectMap()

        new Thread(this).start();

    }

    @Override
    public void run() {

        long stoptime=System.currentTimeMillis()+10*1000;
        while (!Thread.currentThread().isInterrupted()){

            try {

                for(Map.Entry<Integer, Session> entry:sessionManager.getModulepoolbynodeid().entrySet()){
                    Session session=entry.getValue();
                    int nodeid=entry.getKey();
                    if(session!=null){

                        boolean debug=true;
                        if(debug){
                            JSONObject json=new JSONObject();
                            Random random=new Random();
                            json.put("apc1.pv",new Float(random.nextFloat()*100).floatValue());
                            json.put("apc2.pv",new Float(random.nextFloat()*100).floatValue());
//                        CommandImp.PARAM.setNodeid(1234);
                            session.getCtx().writeAndFlush(CommandImp.PARAM.build(json.toJSONString().getBytes("utf-8"),nodeid)) ;
                        }

                        if(false && stoptime<System.currentTimeMillis()){
                            JSONObject json=new JSONObject();
                            Random random=new Random();
                            json.put("msg", "stop");
//                        json.put("apc2.pv",new Float(random.nextFloat()*100).floatValue());
                            //CommandImp.PARAM.setNodeid(1234);
                            session.getCtx().writeAndFlush(CommandImp.STOP.build(json.toJSONString().getBytes("utf-8"),1234)) ;

                        }
                    }



                }
                Session session =sessionManager.getModulepoolbynodeid().get(1234);

                TimeUnit.SECONDS.sleep(3);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
