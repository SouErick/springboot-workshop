package com.project.demospring.entities.enums;

public enum StatusPedido {
	PAGAMENTO_EM_ESPERA(1),
	PAGO(2),
	ENVIADO(3),
	ENTREGUE(4),
	CANCELADO(5);
	
	private int codigo;
	
	private StatusPedido(int codigo) {
		this.codigo = codigo;
	}
	public int getCodigo() {
		return codigo;
	}
	public static StatusPedido valorDe(int codigo) {
		for(StatusPedido obj : StatusPedido.values()) {
			if(obj.getCodigo() == codigo) {
				return obj;
			}
		}
		throw new IllegalArgumentException("Código inválido de status do pedido");
	}
}
