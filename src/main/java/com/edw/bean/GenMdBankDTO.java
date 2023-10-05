package com.edw.bean;

import org.infinispan.protostream.annotations.ProtoDoc;
import org.infinispan.protostream.annotations.ProtoField;

import java.io.Serializable;

/**
 * <pre>
 *     com.edw.bean.GenMdBankDTO
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 05 Okt 2023 11:18
 */
public class GenMdBankDTO implements Serializable {

    @ProtoField(number = 1, required = true)
    protected String bank_id;

    @ProtoField(number = 2)
    protected String sub_account_code;

    @ProtoField(number = 3)
    protected String sub_description;

    @ProtoField(number = 4)
    protected String fi_bank;

    @ProtoField(number = 5)
    protected Integer priority;

    @ProtoDoc("@Field(index=Index.YES, store=Store.NO)")
    @ProtoField(number = 6)
    protected String bank_code;

    @ProtoDoc("@Field(index=Index.YES, store=Store.NO)")
    @ProtoField(number = 7)
    protected String bank_branch;

    @ProtoDoc("@Field(index=Index.YES, store=Store.NO)")
    @ProtoField(number = 8)
    protected String bank_account_no;

    @ProtoDoc("@Field(index=Index.YES, store=Store.NO)")
    @ProtoField(number = 9)
    protected String bank_account_name;

    @ProtoDoc("@Field(index=Index.YES, store=Store.NO)")
    @ProtoField(number = 10)
    protected String currency_code;

    @ProtoField(number = 11)
    protected String fi_plafond;

    @ProtoField(number = 12)
    protected Double bank_fee;

    @ProtoField(number = 13)
    protected String contact_person;

    @ProtoField(number = 14)
    protected String contact_telephone;

    @ProtoField(number = 15)
    protected String email;

    @ProtoField(number = 16)
    protected String record_status;

    public GenMdBankDTO() {
    }

    public GenMdBankDTO(String bank_id, String sub_account_code, String sub_description, String fi_bank,
                        Integer priority, String bank_code, String bank_branch, String bank_account_no,
                        String bank_account_name, String currency_code, String fi_plafond, Double bank_fee,
                        String contact_person, String contact_telephone, String email, String record_status) {
        this.bank_id = bank_id;
        this.sub_account_code = sub_account_code;
        this.sub_description = sub_description;
        this.fi_bank = fi_bank;
        this.priority = priority;
        this.bank_code = bank_code;
        this.bank_branch = bank_branch;
        this.bank_account_no = bank_account_no;
        this.bank_account_name = bank_account_name;
        this.currency_code = currency_code;
        this.fi_plafond = fi_plafond;
        this.bank_fee = bank_fee;
        this.contact_person = contact_person;
        this.contact_telephone = contact_telephone;
        this.email = email;
        this.record_status = record_status;
    }

    public String getBank_id() {
        return bank_id;
    }

    public void setBank_id(String bank_id) {
        this.bank_id = bank_id;
    }

    public String getSub_account_code() {
        return sub_account_code;
    }

    public void setSub_account_code(String sub_account_code) {
        this.sub_account_code = sub_account_code;
    }

    public String getSub_description() {
        return sub_description;
    }

    public void setSub_description(String sub_description) {
        this.sub_description = sub_description;
    }

    public String getFi_bank() {
        return fi_bank;
    }

    public void setFi_bank(String fi_bank) {
        this.fi_bank = fi_bank;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getBank_code() {
        return bank_code;
    }

    public void setBank_code(String bank_code) {
        this.bank_code = bank_code;
    }

    public String getBank_branch() {
        return bank_branch;
    }

    public void setBank_branch(String bank_branch) {
        this.bank_branch = bank_branch;
    }

    public String getBank_account_no() {
        return bank_account_no;
    }

    public void setBank_account_no(String bank_account_no) {
        this.bank_account_no = bank_account_no;
    }

    public String getBank_account_name() {
        return bank_account_name;
    }

    public void setBank_account_name(String bank_account_name) {
        this.bank_account_name = bank_account_name;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }

    public String getFi_plafond() {
        return fi_plafond;
    }

    public void setFi_plafond(String fi_plafond) {
        this.fi_plafond = fi_plafond;
    }

    public Double getBank_fee() {
        return bank_fee;
    }

    public void setBank_fee(Double bank_fee) {
        this.bank_fee = bank_fee;
    }

    public String getContact_person() {
        return contact_person;
    }

    public void setContact_person(String contact_person) {
        this.contact_person = contact_person;
    }

    public String getContact_telephone() {
        return contact_telephone;
    }

    public void setContact_telephone(String contact_telephone) {
        this.contact_telephone = contact_telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRecord_status() {
        return record_status;
    }

    public void setRecord_status(String record_status) {
        this.record_status = record_status;
    }
}
