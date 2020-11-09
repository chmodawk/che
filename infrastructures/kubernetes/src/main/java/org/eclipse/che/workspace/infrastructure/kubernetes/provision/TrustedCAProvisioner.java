/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 */
package org.eclipse.che.workspace.infrastructure.kubernetes.provision;

import org.eclipse.che.api.workspace.server.spi.InfrastructureException;
import org.eclipse.che.workspace.infrastructure.kubernetes.environment.KubernetesEnvironment;
import org.eclipse.che.workspace.infrastructure.kubernetes.namespace.KubernetesNamespace;

/** Provisions trusted CA certificate into Che server components and all workspaces pods. */
public interface TrustedCAProvisioner {
  /**
   * Checks whether additional CA certificates configured. The check is done once on Che server
   * start.
   *
   * @return true if custom CA certificates is configured
   */
  boolean isTrustedStoreInitialized();

  /**
   * Propagates additional CA certificates into config map and mounts them into all pods of given
   * namespace
   *
   * @param k8sEnv available objects in the scope
   * @param namespace namespace into which config map should be provisioned
   * @throws InfrastructureException if failed to CRUD a resource
   */
  void provision(KubernetesEnvironment k8sEnv, KubernetesNamespace namespace)
      throws InfrastructureException;
}