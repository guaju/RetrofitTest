package com.guaju.retrofittest.model.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by guaju on 2018/4/13.
 */

public class UserInfoBean {

    /**
     * status : 200
     * info : 成功
     * data : {"id":100118,"mobile":"15866666666","name":"12312312312312312312","gender":"男","photo":"15866666666_HEAD.jpg\"","last_time":"2018-04-13 08:05:10","state":1,"normal":true,"stateMap":{"1":"正常","9":"停用"}}
     */

    private String status;
    private String info;
    private DataBean data;

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

    public static class DataBean {
        /**
         * id : 100118
         * mobile : 15866666666
         * name : 12312312312312312312
         * gender : 男
         * photo : 15866666666_HEAD.jpg"
         * last_time : 2018-04-13 08:05:10
         * state : 1
         * normal : true
         * stateMap : {"1":"正常","9":"停用"}
         */

        private int id;
        private String mobile;
        private String name;
        private String gender;
        private String photo;
        private String last_time;
        private int state;
        private boolean normal;
        private StateMapBean stateMap;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getLast_time() {
            return last_time;
        }

        public void setLast_time(String last_time) {
            this.last_time = last_time;
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

            @SerializedName("1")
            private String _$1;
            @SerializedName("9")
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
