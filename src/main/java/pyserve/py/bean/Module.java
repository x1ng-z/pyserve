package pyserve.py.bean;

import java.util.List;

/**
 * @author zzx
 * @version 1.0
 * @date 2020/12/29 23:17
 */
public class Module {
    private int nodeid;
    private List<String> inputpins;
    private List<String> outputpins;

    public int getNodeid() {
        return nodeid;
    }

    public void setNodeid(int nodeid) {
        this.nodeid = nodeid;
    }

    public List<String> getInputpins() {
        return inputpins;
    }

    public void setInputpins(List<String> inputpins) {
        this.inputpins = inputpins;
    }

    public List<String> getOutputpins() {
        return outputpins;
    }

    public void setOutputpins(List<String> outputpins) {
        this.outputpins = outputpins;
    }
}
