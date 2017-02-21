package ether.analysis.model;

import javax.persistence.*;

@Entity
public class MinerCreditInfo {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_minercreditinfo_id")
    @SequenceGenerator(initialValue = 1, name = "seq_minercreditinfo_id", sequenceName = "seq_minercreditinfo_id")
    private Long id;

    private int rank;

    private String miner;

    private float hashrate;

    private float erstimatedTtnb;

    private long credit;

    private long timestamp;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getMiner() {
        return miner;
    }

    public void setMiner(String miner) {
        this.miner = miner;
    }

    public float getHashrate() {
        return hashrate;
    }

    public void setHashrate(float hashrate) {
        this.hashrate = hashrate;
    }

    public long getCredit() {
        return credit;
    }

    public void setCredit(long credit) {
        this.credit = credit;
    }

    public float getErstimatedTtnb() {
        return erstimatedTtnb;
    }

    public void setErstimatedTtnb(float erstimatedTtnb) {
        this.erstimatedTtnb = erstimatedTtnb;
    }
}
