CREATE TABLE IF NOT EXISTS erros_quiq
(
  id INT NOT NULL AUTO_INCREMENT,
  ano SMALLINT UNSIGNED NOT NULL,
  categoria_erro VARCHAR(100) NOT NULL DEFAULT 'EM_ANALISE',
  codigo_status SMALLINT UNSIGNED NOT NULL,
  data_erro DATETIME NOT NULL,
  data_padronizada DATE NOT NULL,
  data_pedido DATETIME NOT NULL,
  codigo_empresa SMALLINT UNSIGNED NOT NULL,
  nome_erro VARCHAR(100) NOT NULL,
  mes ENUM('ABR','AGO','DEZ','FEV','JAN','JUL','JUN','MAI','MAR','NOV','OUT','SET') NOT NULL,
  motivo_erro VARCHAR(100) NOT NULL DEFAULT 'EM_ANALISE',
  numero_pdv INT NOT NULL,
  numero_pedido VARCHAR(10) NOT NULL,
  observacao VARCHAR(255) NOT NULL,
  plataforma ENUM('IFOOD','RAPPI') NOT NULL,
  responsavel_analise VARCHAR(20) DEFAULT NULL,
  responsavel_erro VARCHAR(20) NOT NULL DEFAULT 'Em Análise',
  status_analise ENUM('CONCLUIDO','EM_ANALISE') DEFAULT 'EM_ANALISE',
  status_erro ENUM('CONCLUIDO','EM_ANDAMENTO','ON_HOLD') DEFAULT 'EM_ANDAMENTO',
  CONSTRAINT pk_erros_quiq PRIMARY KEY(id),
  INDEX idx_erros_quiq_id (id)
);