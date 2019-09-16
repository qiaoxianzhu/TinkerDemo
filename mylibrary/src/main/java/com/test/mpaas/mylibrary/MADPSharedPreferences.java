package com.test.mpaas.mylibrary;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import java.util.Map;

/**
 * @author Joe
 * @date 2019/9/16.
 * description：键值对存储工具类
 */
public class MADPSharedPreferences {
    private Context sContext = null;
    private String mGroup = "madp_default_sp";
    private SharedPreferences mSP;
    private int mMode = 0;
    private SharedPreferences.Editor edit = null;

    protected MADPSharedPreferences(Context context, String group, int mode) {
        if (context != null) {
            this.sContext = context.getApplicationContext();
        }

        this.mGroup = group;
        this.mMode = mode;
    }

    public void init() {
    }

    private void createEditIfNot() {
        if (this.sContext != null && this.edit == null) {
            synchronized (this) {
                if (this.edit == null) {
                    this.edit = this.sContext.getSharedPreferences(this.getGroup(), this.mMode).edit();
                }
            }
        }

    }

    private void createSPIfNot() {
        if (this.sContext != null && this.mSP == null) {
            synchronized (this) {
                if (this.mSP == null) {
                    this.mSP = this.sContext.getSharedPreferences(this.getGroup(), this.mMode);
                }
            }
        }

    }

    public boolean getBoolean(String key, boolean defValue) {
        return this.getBoolean(this.getGroup(), key, defValue);
    }

    public String getString(String key, String defValue) {
        return this.getString(this.getGroup(), key, defValue);
    }

    public int getInt(String key, int defValue) {
        return this.getInt(this.getGroup(), key, defValue);
    }

    public long getLong(String key, long defValue) {
        return this.getLong(this.getGroup(), key, defValue);
    }

    public float getFloat(String key, float defValue) {
        return this.getFloat(this.getGroup(), key, defValue);
    }

    public boolean putInt(String key, int value) {
        return this.putInt(this.getGroup(), key, value);
    }

    public boolean putBoolean(String key, boolean value) {
        return this.putBoolean(this.getGroup(), key, value);
    }

    public boolean putString(String key, String value) {
        return this.putString(this.getGroup(), key, value);
    }

    public boolean putLong(String key, long value) {
        return this.putLong(this.getGroup(), key, value);
    }

    public boolean putFloat(String key, float value) {
        return this.putFloat(this.getGroup(), key, value);
    }

    public boolean contains(String key) {
        return this.contains(this.getGroup(), key);
    }

    public boolean commit() {
        this.createEditIfNot();
        return this.edit != null ? this.edit.commit() : false;
    }

    public void apply() {
        this.createEditIfNot();
        if (this.edit != null) {
            this.edit.apply();
        }

    }

    public boolean remove(String key) {
        this.createEditIfNot();
        if (this.edit != null && !TextUtils.isEmpty(key)) {
            this.edit.remove(key);
            return true;
        } else {
            return false;
        }
    }

    public boolean clear() {
        this.createEditIfNot();
        if (this.edit != null) {
            this.edit.clear();
            return true;
        } else {
            return false;
        }
    }

    public Map<String, ?> getAll() {
        if (this.sContext != null) {
            if (this.mMode == 0) {
                this.createSPIfNot();
                return this.mSP.getAll();
            } else {
                return this.sContext.getSharedPreferences(this.getGroup(), this.mMode).getAll();
            }
        } else {
            return null;
        }
    }

    private boolean contains(String name, String key) {
        if (this.sContext != null) {
            if (this.mMode == 0) {
                this.createSPIfNot();
                return this.mSP.contains(key);
            } else {
                return this.sContext.getSharedPreferences(name, this.mMode).contains(key);
            }
        } else {
            return false;
        }
    }

    private boolean getBoolean(String name, String key, boolean defValue) {
        if (this.sContext != null) {
            if (this.mMode == 0) {
                this.createSPIfNot();
                return this.mSP.getBoolean(key, defValue);
            } else {
                return this.sContext.getSharedPreferences(name, this.mMode).getBoolean(key, defValue);
            }
        } else {
            return defValue;
        }
    }

    private String getString(String name, String key, String defValue) {
        if (this.sContext != null) {
            if (this.mMode == 0) {
                this.createSPIfNot();
                return this.mSP.getString(key, defValue);
            } else {
                return this.sContext.getSharedPreferences(name, this.mMode).getString(key, defValue);
            }
        } else {
            return defValue;
        }
    }

    private int getInt(String name, String key, int defValue) {
        if (this.sContext != null) {
            if (this.mMode == 0) {
                this.createSPIfNot();
                return this.mSP.getInt(key, defValue);
            } else {
                return this.sContext.getSharedPreferences(name, this.mMode).getInt(key, defValue);
            }
        } else {
            return defValue;
        }
    }

    private long getLong(String name, String key, long defValue) {
        if (this.sContext != null) {
            if (this.mMode == 0) {
                this.createSPIfNot();
                return this.mSP.getLong(key, defValue);
            } else {
                return this.sContext.getSharedPreferences(name, this.mMode).getLong(key, defValue);
            }
        } else {
            return defValue;
        }
    }

    private float getFloat(String name, String key, float defValue) {
        if (this.sContext != null) {
            if (this.mMode == 0) {
                this.createSPIfNot();
                return this.mSP.getFloat(key, defValue);
            } else {
                return this.sContext.getSharedPreferences(name, this.mMode).getFloat(key, defValue);
            }
        } else {
            return defValue;
        }
    }

    private boolean putInt(String name, String key, int value) {
        this.createEditIfNot();
        if (this.edit != null) {
            this.edit.putInt(key, value);
            return true;
        } else {
            return false;
        }
    }

    private boolean putBoolean(String name, String key, boolean value) {
        this.createEditIfNot();
        if (this.edit != null) {
            this.edit.putBoolean(key, value);
            return true;
        } else {
            return false;
        }
    }

    private boolean putString(String name, String key, String value) {
        this.createEditIfNot();
        if (this.edit != null) {
            this.edit.putString(key, value);
            return true;
        } else {
            return false;
        }
    }

    private boolean putLong(String name, String key, long value) {
        this.createEditIfNot();
        if (this.edit != null) {
            this.edit.putLong(key, value);
            return true;
        } else {
            return false;
        }
    }

    private boolean putFloat(String name, String key, float value) {
        this.createEditIfNot();
        if (this.edit != null) {
            this.edit.putFloat(key, value);
            return true;
        } else {
            return false;
        }
    }

    private String getGroup() {
        return this.mGroup;
    }
}
