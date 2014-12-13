package api.domain.response;

import java.util.List;

/**
 * Created by tomas on 14.12.13.
 */
public class ListWrapper {
    private List list;

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public ListWrapper (List list) {
        this.list = list;
    }
}
