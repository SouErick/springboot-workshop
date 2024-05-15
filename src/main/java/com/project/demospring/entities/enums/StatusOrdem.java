package com.project.demospring.entities.enums;

public enum StatusOrdem {
	PAGAMENTO_EM_ESPERA(1),
	PAGO(2),
	ENVIADO(3),
	ENTREGUE(4),
	CANCELADO(5);
	
	private int codigo;
	
	private StatusOrdem(int codigo) {
		this.codigo = codigo;
	}
	public int getCodigo() {
		return codigo;
	}
	public static StatusOrdem valorDe(int codigo) {
		for(StatusOrdem obj : StatusOrdem.values()) {
			if(obj.getCodigo() == codigo) {
				return obj;
			}
		}
		throw new IllegalArgumentException("Código inválido de status do pedido");
	}
}
