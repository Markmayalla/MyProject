package tz.co.comptech.m_safariproduction.Model;


public class AutoCompleteRegion {
    private String region_id;
    private String _id;
    private String name;
    private String __v;

    public AutoCompleteRegion(String region_id, String _id, String name, String __v) {
        this.region_id = region_id;
        this._id = _id;
        this.name = name;
        this.__v = __v;
    }

    public String getRegion_id() {
        return region_id;
    }

    public String get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public String get__v() {
        return __v;
    }
}
