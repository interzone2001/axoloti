package axoloti.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Represents a location for objects and patches to be picked up
 */
// this will become abstract
// (currently this is used to hold the data, so that the library editor is is typeless)

@Root(name = "library")
public class AxolotiLibrary {

    @Element(required = true)
    private String Id;
    @Element(required = true)
    private String Type;
    @Element(required = true)
    private String LocalLocation;
    @Element(required = true)
    private Boolean Enabled;
    @Element(required = false)

    // these are only requird for remote libraries
    private String RemoteLocation;
    @Element(required = false)
    private String UserId;
    @Element(required = false)
    private String Password;
    @Element(required = false)
    private boolean AutoSync;
    @Element(required = false)
    private String Revision;
    @Element(required = false)
    private String ContributorPrefix;

    public static String FACTORY_ID = "axoloti-factory";
    public static String USER_LIBRARY_ID = "axoloti-contrib";

    public AxolotiLibrary() {
        Id = "";
        Type = "local";
        Enabled = true;
        LocalLocation = "";
        RemoteLocation = "";
        UserId = "";
        Password = "";
        AutoSync = false;
    }

    public AxolotiLibrary(String id, String type, String lloc, boolean e, String rloc, boolean auto) {
        Id = id;
        Type = type;
        LocalLocation = lloc;
        Enabled = e;
        RemoteLocation = rloc;
        UserId = "";
        Password = "";
        AutoSync = auto;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public void setLocalLocation(String LocalLocation) {
        this.LocalLocation = LocalLocation;
    }

    public void setEnabled(Boolean Enabled) {
        this.Enabled = Enabled;
    }

    public void setRemoteLocation(String RemoteLocation) {
        this.RemoteLocation = RemoteLocation;
    }

    public String getId() {
        return Id;
    }

    public String getType() {
        return Type;
    }

    public String getLocalLocation() {
        return LocalLocation;
    }

    public Boolean getEnabled() {
        return Enabled;
    }

    public String getRemoteLocation() {
        return RemoteLocation;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public boolean isAutoSync() {
        return AutoSync;
    }

    public void setAutoSync(boolean AutoSync) {
        this.AutoSync = AutoSync;
    }

    // interface to libraries
    public void sync() {
    }

    public void init() {
    }

    protected void delete(File f) throws IOException {
        if (f.isDirectory()) {
            for (File c : f.listFiles()) {
                delete(c);
            }
        }
        if (!f.delete()) {
            throw new FileNotFoundException("Failed to delete file: " + f);
        }
    }

    public String getRevision() {
        return Revision;
    }

    public void setRevision(String Revision) {
        this.Revision = Revision;
    }

    public String getContributorPrefix() {
        return ContributorPrefix;
    }

    public void setContributorPrefix(String ContributorPrefix) {
        this.ContributorPrefix = ContributorPrefix;
    }
}