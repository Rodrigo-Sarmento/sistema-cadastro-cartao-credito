-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: 16-Nov-2019 às 21:24
-- Versão do servidor: 5.7.24
-- versão do PHP: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projetofinal`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cargo`
--

DROP TABLE IF EXISTS `cargo`;
CREATE TABLE IF NOT EXISTS `cargo` (
  `id_cargo` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(300) DEFAULT NULL,
  `salario` double DEFAULT NULL,
  `tempo_trabalho` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id_cargo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cargo`
--

INSERT INTO `cargo` (`id_cargo`, `nome`, `salario`, `tempo_trabalho`) VALUES
(4, 'gerente', 5000, '08:00'),
(5, 'atendente', 3000, '08:00');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cartao`
--

DROP TABLE IF EXISTS `cartao`;
CREATE TABLE IF NOT EXISTS `cartao` (
  `id_cartao` int(11) NOT NULL AUTO_INCREMENT,
  `fk_cliente` int(11) UNSIGNED NOT NULL,
  `nome` varchar(300) DEFAULT NULL,
  `data_validade` varchar(100) DEFAULT NULL,
  `cod_seguranca` varchar(100) DEFAULT NULL,
  `num_cartao` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_cartao`),
  KEY `fk_cliente` (`fk_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cartao`
--

INSERT INTO `cartao` (`id_cartao`, `fk_cliente`, `nome`, `data_validade`, `cod_seguranca`, `num_cartao`) VALUES
(1, 6, 'joao dois', '30/10/2020', '1234', '9999-9887-7777-2222'),
(2, 1, 'joao da silva costa', '30/10/2080', '12314e123', '5566-6223-4212-2222'),
(3, 9, 'tobias nascimento', '01/02/2020', '33344411', '1333-1111-2344-4444');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `id_cliente` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `nome` varchar(300) DEFAULT NULL,
  `data_nascimento` varchar(100) DEFAULT NULL,
  `cpf` varchar(100) DEFAULT NULL,
  `rg` varchar(100) DEFAULT NULL,
  `endereco` varchar(300) DEFAULT NULL,
  `telefone` varchar(100) DEFAULT NULL,
  `salario` double DEFAULT NULL,
  `profissao` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id_cliente`),
  UNIQUE KEY `id_cliente` (`id_cliente`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `nome`, `data_nascimento`, `cpf`, `rg`, `endereco`, `telefone`, `salario`, `profissao`) VALUES
(1, 'joão silva costa', '01/10/1000', '444.666.778-88', '56.127.371-7', 'rua alguma coisa', '(81)99999-9222', 3000, 'secretário'),
(4, 'ricardo', '23/12/3444', '123.441.123-33', '11.233.344-4', 'tgjjjaa', '(32)44412-3111', 8000, 'empresário'),
(5, 'charles', '11/11/1111', '111.222.211-11', '11.233.311-1', 'rua sol', '(11)22221-1111', 1000, 'garimpeiro'),
(6, 'james silveira', '30/10/1890', '853.937.465-28', '34.811.827-3', 'avenida queiroz', '(11)33234-6253', 12000, 'médico'),
(7, 'josé medeiros', '11/23/1743', '776.667.766-66', '12.221.134-5', 'asdasdad', '(32)28888-8111', 6000, 'eletricista'),
(8, 'brendo costa', '10/02/1078', '333.333.111-11', '22.333.333-3', 'rua abc', '(11)22111-1111', 8000, 'escultor'),
(9, 'guilherme antonio', '23/12/1998', '677.776.677-67', '22.331.112-2', 'rua 81', '(81)88873-7382', 9000, 'arquiteto');

-- --------------------------------------------------------

--
-- Estrutura da tabela `dependente`
--

DROP TABLE IF EXISTS `dependente`;
CREATE TABLE IF NOT EXISTS `dependente` (
  `id_dependente` int(11) NOT NULL AUTO_INCREMENT,
  `fk_cliente` int(11) UNSIGNED NOT NULL,
  `cpf` varchar(100) NOT NULL,
  `data_nascimento` varchar(100) NOT NULL,
  `endereco` varchar(100) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `profissao` varchar(100) NOT NULL,
  `rg` varchar(100) NOT NULL,
  `salario` double NOT NULL,
  `telefone` varchar(100) NOT NULL,
  PRIMARY KEY (`id_dependente`),
  KEY `fk_cliente` (`fk_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `dependente`
--

INSERT INTO `dependente` (`id_dependente`, `fk_cliente`, `cpf`, `data_nascimento`, `endereco`, `nome`, `profissao`, `rg`, `salario`, `telefone`) VALUES
(1, 5, '120.112.010-20', '02/01/2001', 'rua 21', 'alexender costa da silva', 'dentista', '01.201.201-2', 2100, '(10)20101-2010'),
(3, 8, '888.888.777-77', '01/02/2001', 'rua 65', 'brendo costa jr', 'pedreiro', '11.112.222-2', 3000, '(72)77777-7777'),
(4, 9, '127.547.133-51', '01/01/0001', 'rua um', 'tobias nascimento', 'empresário', '12.836.153-8', 45000, '(12)37423-7362');

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
CREATE TABLE IF NOT EXISTS `funcionario` (
  `id_funcionario` int(11) NOT NULL AUTO_INCREMENT,
  `fk_cargo` int(11) NOT NULL,
  `nome` varchar(300) DEFAULT NULL,
  `cpf` varchar(100) DEFAULT NULL,
  `salario` double DEFAULT NULL,
  PRIMARY KEY (`id_funcionario`),
  KEY `fk_cargo` (`fk_cargo`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`id_funcionario`, `fk_cargo`, `nome`, `cpf`, `salario`) VALUES
(5, 5, 'maria silva', '333.111.222-11', 5000),
(6, 4, 'tiago dos santos', '993.322.222-33', 7000);

-- --------------------------------------------------------

--
-- Estrutura da tabela `precadastro`
--

DROP TABLE IF EXISTS `precadastro`;
CREATE TABLE IF NOT EXISTS `precadastro` (
  `id_precliente` int(11) NOT NULL AUTO_INCREMENT,
  `cpf` varchar(100) NOT NULL,
  `data_nascimento` varchar(100) NOT NULL,
  `endereco` varchar(100) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `profissao` varchar(100) NOT NULL,
  `rg` varchar(100) NOT NULL,
  `salario` double NOT NULL,
  `telefone` varchar(100) NOT NULL,
  PRIMARY KEY (`id_precliente`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `precadastro`
--

INSERT INTO `precadastro` (`id_precliente`, `cpf`, `data_nascimento`, `endereco`, `nome`, `profissao`, `rg`, `salario`, `telefone`) VALUES
(4, '333.444.333-33', '11/11/1111', 'asasa', 'rodrigo gomes', 'programador java', '55.555.533-3', 7000, '(33)33322-2222'),
(9, '918.303.018-73', '12/07/2007', 'ipsep', 'geremias', 'motorista', '33.311.111-1', 4000, '(81)27363-5171');

-- --------------------------------------------------------

--
-- Estrutura da tabela `spc`
--

DROP TABLE IF EXISTS `spc`;
CREATE TABLE IF NOT EXISTS `spc` (
  `id_pessoa` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(300) DEFAULT NULL,
  `cpf` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_pessoa`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `spc`
--

INSERT INTO `spc` (`id_pessoa`, `nome`, `cpf`) VALUES
(1, 'rodrigo gomes', '123.456.789-10'),
(3, 'allan da silva', '777.666.555-44'),
(5, 'joão da silva', '111.222.333-99');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `fk_funcionario` int(11) NOT NULL,
  `login` varchar(300) DEFAULT NULL,
  `senha` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `fk_funcionario` (`fk_funcionario`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `fk_funcionario`, `login`, `senha`) VALUES
(5, 5, 'atendente', '123'),
(6, 6, 'gerente', '123');

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `cartao`
--
ALTER TABLE `cartao`
  ADD CONSTRAINT `cartao_ibfk_1` FOREIGN KEY (`fk_cliente`) REFERENCES `cliente` (`id_cliente`);

--
-- Limitadores para a tabela `dependente`
--
ALTER TABLE `dependente`
  ADD CONSTRAINT `dependente_ibfk_1` FOREIGN KEY (`fk_cliente`) REFERENCES `cliente` (`id_cliente`);

--
-- Limitadores para a tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD CONSTRAINT `funcionario_ibfk_1` FOREIGN KEY (`fk_cargo`) REFERENCES `cargo` (`id_cargo`);

--
-- Limitadores para a tabela `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`fk_funcionario`) REFERENCES `funcionario` (`id_funcionario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
