package io.example.patterns.adapter.cases;

/**
 * @author luxz
 * @date 2022/11/12-06:09
 */
public class ForeignCenterAdapter extends Player {
    private final ForeignCenter foreignCenter = new ForeignCenter();

    public ForeignCenterAdapter(String name) {
        super(name);
        foreignCenter.setName(name);
    }

    @Override
    public void Attack() {
        foreignCenter.JinGong();
    }

    @Override
    public void Defence() {
        foreignCenter.FangShou();

    }
}
