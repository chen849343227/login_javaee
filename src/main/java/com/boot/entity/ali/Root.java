package com.boot.entity.ali;

public class Root {
	private Alibaba_aliqin_fc_sms_num_send_response alibaba_aliqin_fc_sms_num_send_response;

	public void setAlibaba_aliqin_fc_sms_num_send_response(
			Alibaba_aliqin_fc_sms_num_send_response alibaba_aliqin_fc_sms_num_send_response) {
		this.alibaba_aliqin_fc_sms_num_send_response = alibaba_aliqin_fc_sms_num_send_response;
	}

	public Alibaba_aliqin_fc_sms_num_send_response getAlibaba_aliqin_fc_sms_num_send_response() {
		return this.alibaba_aliqin_fc_sms_num_send_response;
	}

	public  class Alibaba_aliqin_fc_sms_num_send_response {
		private Result result;

		private String request_id;

		public void setResult(Result result) {
			this.result = result;
		}

		public Result getResult() {
			return this.result;
		}

		public void setRequest_id(String request_id) {
			this.request_id = request_id;
		}

		public String getRequest_id() {
			return this.request_id;
		}

	}

	public class Result {
		private String err_code;

		private String model;

		private boolean success;

		public void setErr_code(String err_code) {
			this.err_code = err_code;
		}

		public String getErr_code() {
			return this.err_code;
		}

		public void setModel(String model) {
			this.model = model;
		}

		public String getModel() {
			return this.model;
		}

		public void setSuccess(boolean success) {
			this.success = success;
		}

		public boolean getSuccess() {
			return this.success;
		}

	}
}
