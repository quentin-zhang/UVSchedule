package com.uv.other.weixinyinlian;

public class UnionEntity {


    public Enterprise get企业() {
        return 企业;
    }

    public void set企业(Enterprise 企业) {
        this.企业 = 企业;
    }

    public Single get个体工商户() {
        return 个体工商户;
    }

    public void set个体工商户(Single 个体工商户) {
        this.个体工商户 = 个体工商户;
    }

    public Work get政府及事业单位() {
        return 政府及事业单位;
    }

    public void set政府及事业单位(Work 政府及事业单位) {
        this.政府及事业单位 = 政府及事业单位;
    }

    public Other get其他组织() {
        return 其他组织;
    }

    public void set其他组织(Other 其他组织) {
        this.其他组织 = 其他组织;
    }

    private Enterprise 企业;
    private Single 个体工商户;
    private Work 政府及事业单位;
    private Other 其他组织;
}
