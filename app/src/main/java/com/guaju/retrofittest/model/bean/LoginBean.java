package com.guaju.retrofittest.model.bean;

/**
 * Created by guaju on 2018/4/13.
 */

public class LoginBean {


    /**
     * status : 200
     * info : 成功
     * data : {"id":100118,"name":"12312312312312312312","state":1,"normal":true,"stateMap":{"1":"正常","9":"停用"}}
     * token : 422507ED203A4AD6BB329CBC30E464FF
     */

    private String status;
    private String info;
    private DataBean data;
    private String token;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static class DataBean {
        /**
         * id : 100118
         * name : 12312312312312312312
         * state : 1
         * normal : true
         * stateMap : {"1":"正常","9":"停用"}
         */

        private int id;
        private String name;
        private int state;
        private boolean normal;
        private StateMapBean stateMap;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public boolean isNormal() {
            return normal;
        }

        public void setNormal(boolean normal) {
            this.normal = normal;
        }

        public StateMapBean getStateMap() {
            return stateMap;
        }

        public void setStateMap(StateMapBean stateMap) {
            this.stateMap = stateMap;
        }

        public static class StateMapBean {
            /**
             * 1 : 正常
             * 9 : 停用
             */

            @com.google.gson.annotations.SerializedName("1")
            private String _$1;
            @com.google.gson.annotations.SerializedName("9")
            private String _$9;

            public String get_$1() {
                return _$1;
            }

            public void set_$1(String _$1) {
                this._$1 = _$1;
            }

            public String get_$9() {
                return _$9;
            }

            public void set_$9(String _$9) {
                this._$9 = _$9;
            }
        }
    }
}
