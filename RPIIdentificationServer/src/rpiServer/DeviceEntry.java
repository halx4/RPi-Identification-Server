// Author: F. Christoulakis

package rpiServer;

public class DeviceEntry {
	private String id;
	private String ip;
	private long lastUpdatedTime;

	DeviceEntry() {
	}

	// ---------------------------
	DeviceEntry(String id, String ip) {
		this.id = id;
		this.ip = ip;

	}

	// ------------------------
	long getLastUpdatedTime() {
		return lastUpdatedTime;
	}

	// ------------------------
	void setLastUpdatedTime(long lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}

	// ------------------------
	String getId() {
		return id;
	}

	// ------------------------
	void setId(String id) {
		this.id = id;
	}

	// ------------------------
	String getIp() {
		return ip;
	}

	// ------------------------
	void setIp(String ip) {
		this.ip = ip;
	}

	// ------------------------
	public String toString() {
		return (id + " " + ip + " " + Long
				.toString((System.currentTimeMillis() - lastUpdatedTime) / 1000));
	}

	// ------------------------
	public int getSecFromLastUpdate() {
		int seconds = Math
				.round((System.currentTimeMillis() - lastUpdatedTime) / 1000F);
		// System.out.println("second="+seconds);
		return seconds;
	}
}
